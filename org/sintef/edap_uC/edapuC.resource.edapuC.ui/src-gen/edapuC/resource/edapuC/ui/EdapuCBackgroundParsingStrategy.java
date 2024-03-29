/*******************************************************************************
 * Copyright (c) 2010 SINTEF
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SINTEF - initial API and implementation
 ******************************************************************************/
 
package edapuC.resource.edapuC.ui;

/**
 * A background parsing strategy that starts parsing after a amount of time after
 * the last key stroke. If keys are pressed within the delay interval, the delay
 * is reset. If keys are pressed during background parsing the parse thread is
 * stopped and a new parse task is scheduled.
 */
public class EdapuCBackgroundParsingStrategy {
	
	private static long DELAY = 500;
	
	/**
	 * this timer is used to schedule a parsing task and execute it after a given delay
	 */
	private Object lock = new Object();
	
	/**
	 * the background parsing task (may be null)
	 */
	private org.eclipse.core.runtime.jobs.Job job;
	
	/**
	 * Schedules a task for background parsing that will be started after a delay.
	 */
	public void parse(org.eclipse.jface.text.DocumentEvent event, final edapuC.resource.edapuC.IEdapuCTextResource resource, final edapuC.resource.edapuC.ui.EdapuCEditor editor) {
		if (resource == null) {
			return;
		}
		final String contents = event.getDocument().get();
		if (contents == null) {
			return;
		}
		
		// this synchronization is needed to avoid the creation of multiple tasks. without
		// the synchronization this could easily happen, when this method is accessed by
		// multiple threads. the creation of multiple tasks would imply the multiple
		// background parsing threads for one editor are created, which is not desired.
		synchronized (lock) {
			// cancel old task
			if (job != null) {
				// stop current parser (if there is one)
				job.cancel();
				try {
					job.join();
				} catch (InterruptedException e) {}
			}
			
			// schedule new task
			job = new org.eclipse.core.runtime.jobs.Job("parsing document") {
				
				protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
					try {
						resource.reload(new java.io.ByteArrayInputStream(contents.getBytes()), null);
					} catch (java.io.IOException e) {
						e.printStackTrace();
					}
					// the post parsing stuff must be executed in a separate job to avoid deadlocks on
					// the document
					org.eclipse.core.runtime.jobs.Job finishJob = new org.eclipse.core.runtime.jobs.Job("refreshing views") {
						protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
							editor.notifyBackgroundParsingFinished();
							return org.eclipse.core.runtime.Status.OK_STATUS;
						}
					};
					finishJob.schedule(10);
					return org.eclipse.core.runtime.Status.OK_STATUS;
				}
				
				protected void canceling() {
					resource.cancelReload();
				}
			};
			job.schedule(DELAY);
		}
	}
}

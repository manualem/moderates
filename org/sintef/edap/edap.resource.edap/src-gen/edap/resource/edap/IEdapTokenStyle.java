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
 
package edap.resource.edap;

/**
 * A common interface for token styles. Text resources must return style
 * information using classes that implement this interface.
 */
public interface IEdapTokenStyle {
	
	/**
	 * Returns the color of the token as array of length 3.
	 */
	public int[] getColorAsRGB();
	
	/**
	 * Returns the background color of the token as array of length 3. This method can
	 * return <code>null</code> if no background color is set.
	 */
	public int[] getBackgroundColorAsRGB();
	
	/**
	 * Returns true if the token must be displayed in bold face.
	 */
	public boolean isBold();
	
	/**
	 * Returns true if the token must be displayed in italic face.
	 */
	public boolean isItalic();
	
	/**
	 * Returns true if the token must be displayed in strike through style.
	 */
	public boolean isStrikethrough();
	
	/**
	 * Returns true if the token must be displayed underlined.
	 */
	public boolean isUnderline();
	
}

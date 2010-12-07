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
 
package edapuC.resource.edapuC.mopp;

public class EdapuCResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements edapuC.resource.edapuC.IEdapuCTextResource {
	
	public class ElementBasedTextDiagnostic implements edapuC.resource.edapuC.IEdapuCTextDiagnostic {
		
		private final edapuC.resource.edapuC.IEdapuCLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final edapuC.resource.edapuC.IEdapuCProblem problem;
		
		public ElementBasedTextDiagnostic(edapuC.resource.edapuC.IEdapuCLocationMap locationMap, org.eclipse.emf.common.util.URI uri, edapuC.resource.edapuC.IEdapuCProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public edapuC.resource.edapuC.IEdapuCProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements edapuC.resource.edapuC.IEdapuCTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private edapuC.resource.edapuC.IEdapuCProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, edapuC.resource.edapuC.IEdapuCProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public edapuC.resource.edapuC.IEdapuCProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch resolverSwitch;
	private edapuC.resource.edapuC.IEdapuCLocationMap locationMap;
	private int proxyCounter = 0;
	private edapuC.resource.edapuC.IEdapuCTextParser parser;
	private java.util.Map<String, edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, edapuC.resource.edapuC.IEdapuCQuickFix> quickFixMap = new java.util.LinkedHashMap<String, edapuC.resource.edapuC.IEdapuCQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	public EdapuCResource() {
		super();
		resetLocationMap();
	}
	
	public EdapuCResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		this.loadOptions = options;
		String encoding = null;
		java.io.InputStream actualInputStream = inputStream;
		Object inputStreamPreProcessorProvider = null;
		if (options!=null) {
			inputStreamPreProcessorProvider = options.get(edapuC.resource.edapuC.IEdapuCOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
		}
		if (inputStreamPreProcessorProvider != null) {
			if (inputStreamPreProcessorProvider instanceof edapuC.resource.edapuC.IEdapuCInputStreamProcessorProvider) {
				edapuC.resource.edapuC.IEdapuCInputStreamProcessorProvider provider = (edapuC.resource.edapuC.IEdapuCInputStreamProcessorProvider) inputStreamPreProcessorProvider;
				edapuC.resource.edapuC.mopp.EdapuCInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
				actualInputStream = processor;
				encoding = processor.getOutputEncoding();
			}
		}
		
		parser = getMetaInformation().createParser(actualInputStream, encoding);
		parser.setOptions(options);
		edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		edapuC.resource.edapuC.IEdapuCParseResult result = parser.parse();
		clearState();
		getContents().clear();
		org.eclipse.emf.ecore.EObject root = null;
		if (result != null) {
			root = result.getRoot();
			if (root != null) {
				getContents().add(root);
			}
			java.util.Collection<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>> commands = result.getPostParseCommands();
			if (commands != null) {
				for (edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>  command : commands) {
					command.execute(this);
				}
			}
		}
		getReferenceResolverSwitch().setOptions(options);
		if (getErrors().isEmpty()) {
			runPostProcessors(options);
			if (root != null) {
				runValidators(root);
			}
		}
	}
	
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		try {
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
			doLoad(inputStream, loadOptions);
		} catch (edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException tpe) {
			// do nothing - the resource is left unchanged if this exception is thrown
		}
		isLoaded = true;
	}
	
	public void cancelReload() {
		edapuC.resource.edapuC.IEdapuCTextParser parserCopy = parser;
		parserCopy.terminate();
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		edapuC.resource.edapuC.IEdapuCTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		referenceResolverSwitch.setOptions(options);
		for(org.eclipse.emf.ecore.EObject root : getContents()) {
			printer.print(root);
		}
	}
	
	protected String getSyntaxName() {
		return "edapuC";
	}
	
	public edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public edapuC.resource.edapuC.mopp.EdapuCMetaInformation getMetaInformation() {
		return new edapuC.resource.edapuC.mopp.EdapuCMetaInformation();
	}
	
	protected void resetLocationMap() {
		locationMap = new edapuC.resource.edapuC.mopp.EdapuCLocationMap();
	}
	
	public void addURIFragment(String internalURIFragment, edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(edapuC.resource.edapuC.IEdapuCContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement) {
		int pos = -1;
		if (reference.isMany()) {
			pos = ((java.util.List<?>)container.eGet(reference)).size();
		}
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = edapuC.resource.edapuC.IEdapuCContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, pos, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			edapuC.resource.edapuC.IEdapuCReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = uriFragment.resolve();
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachErrors(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachWarnings(result, proxy);
				edapuC.resource.edapuC.IEdapuCReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter) {
				edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter layoutInformationAdapter = (edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	private org.eclipse.emf.ecore.EObject getResultElement(edapuC.resource.edapuC.IEdapuCContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, edapuC.resource.edapuC.IEdapuCReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof edapuC.resource.edapuC.IEdapuCURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((edapuC.resource.edapuC.IEdapuCURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(errorMessage, edapuC.resource.edapuC.EdapuCEProblemType.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof edapuC.resource.edapuC.IEdapuCElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((edapuC.resource.edapuC.IEdapuCElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = edapuC.resource.edapuC.util.EdapuCCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	private void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof edapuC.resource.edapuC.IEdapuCTextDiagnostic) {
				if (((edapuC.resource.edapuC.IEdapuCTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
				}
			}
		}
	}
	
	private void attachErrors(edapuC.resource.edapuC.IEdapuCReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(errorMessage, edapuC.resource.edapuC.EdapuCEProblemType.ERROR), proxy);
		}
	}
	
	private void attachWarnings(edapuC.resource.edapuC.IEdapuCReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (edapuC.resource.edapuC.IEdapuCReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(warningMessage, edapuC.resource.edapuC.EdapuCEProblemType.ERROR), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	protected void runPostProcessors(java.util.Map<?, ?> loadOptions) {
		if (loadOptions == null) {
			return;
		}
		Object resourcePostProcessorProvider = loadOptions.get(edapuC.resource.edapuC.IEdapuCOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof edapuC.resource.edapuC.IEdapuCResourcePostProcessorProvider) {
				((edapuC.resource.edapuC.IEdapuCResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor().process(this);
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processorProvider instanceof edapuC.resource.edapuC.IEdapuCResourcePostProcessorProvider) {
						edapuC.resource.edapuC.IEdapuCResourcePostProcessorProvider csProcessorProvider = (edapuC.resource.edapuC.IEdapuCResourcePostProcessorProvider) processorProvider;
						edapuC.resource.edapuC.IEdapuCResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						try {
							postProcessor.process(this);
						} catch (Exception e) {
							edapuC.resource.edapuC.mopp.EdapuCPlugin.logError("Exception while running a post-processor.", e);
						}
					}
				}
			}
		}
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	public edapuC.resource.edapuC.IEdapuCLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(edapuC.resource.edapuC.IEdapuCProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getType()).add(diagnostic);
		if (isMarkerCreationEnabled()) {
			edapuC.resource.edapuC.mopp.EdapuCMarkerHelper.mark(this, diagnostic);
		}
		java.util.Collection<edapuC.resource.edapuC.IEdapuCQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (edapuC.resource.edapuC.IEdapuCQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	public void addProblem(edapuC.resource.edapuC.IEdapuCProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getType()).add(diagnostic);
		if (isMarkerCreationEnabled()) {
			edapuC.resource.edapuC.mopp.EdapuCMarkerHelper.mark(this, diagnostic);
		}
	}
	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(message, edapuC.resource.edapuC.EdapuCEProblemType.ERROR), cause);
	}
	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(message, edapuC.resource.edapuC.EdapuCEProblemType.WARNING), cause);
	}
	
	private java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(edapuC.resource.edapuC.EdapuCEProblemType type) {
		if (type == edapuC.resource.edapuC.EdapuCEProblemType.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = edapuC.resource.edapuC.util.EdapuCMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			// find default load option providers
			org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
			org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(edapuC.resource.edapuC.mopp.EdapuCPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
				try {
					edapuC.resource.edapuC.IEdapuCOptionProvider provider = (edapuC.resource.edapuC.IEdapuCOptionProvider) element.createExecutableExtension("class");
					final java.util.Map<?, ?> options = provider.getOptions();
					final java.util.Collection<?> keys = options.keySet();
					for (Object key : keys) {
						addLoadOption(loadOptionsCopy, key, options.get(key));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					edapuC.resource.edapuC.mopp.EdapuCPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Adds a new key,value pair to the list of options. If there is already an option
	 * with the same key, the two values are collected in a list.
	 */
	private void addLoadOption(java.util.Map<Object, Object> options,Object key, Object value) {
		// check if there is already an option set
		if (options.containsKey(key)) {
			Object currentValue = options.get(key);
			if (currentValue instanceof java.util.List<?>) {
				// if the current value is a list, we add the new value to this list
				java.util.List<?> currentValueAsList = (java.util.List<?>) currentValue;
				java.util.List<Object> currentValueAsObjectList = edapuC.resource.edapuC.util.EdapuCListUtil.copySafelyToObjectList(currentValueAsList);
				if (value instanceof java.util.Collection<?>) {
					currentValueAsObjectList.addAll((java.util.Collection<?>) value);
				} else {
					currentValueAsObjectList.add(value);
				}
				options.put(key, currentValueAsObjectList);
			} else {
				// if the current value is not a list, we create a fresh list and add both the old
				// (current) and the new value to this list
				java.util.List<Object> newValueList = new java.util.ArrayList<Object>();
				newValueList.add(currentValue);
				if (value instanceof java.util.Collection<?>) {
					newValueList.addAll((java.util.Collection<?>) value);
				} else {
					newValueList.add(value);
				}
				options.put(key, newValueList);
			}
		} else {
			options.put(key, value);
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		if (isMarkerCreationEnabled()) {
			edapuC.resource.edapuC.mopp.EdapuCMarkerHelper.unmark(this);
		}
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		return new edapuC.resource.edapuC.util.EdapuCCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		return new edapuC.resource.edapuC.util.EdapuCCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		return new edapuC.resource.edapuC.util.EdapuCCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	@SuppressWarnings("restriction")	
	private void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled
		
		// check EMF validation constraints
		// EMF validation does not work if OSGi is not running
		// The EMF validation framework code throws a NPE if the validation plug-in is not
		// loaded. This is a bug, which is fixed in the Helios release. Nonetheless, we
		// need to catch the exception here.
		if (org.eclipse.core.runtime.Platform.isRunning()) {
			// The EMF validation framework code throws a NPE if the validation plug-in is not
			// loaded. This is a workaround for bug 322079.
			if (org.eclipse.emf.validation.internal.EMFModelValidationPlugin.getPlugin() != null) {
				try {
					org.eclipse.emf.validation.service.ModelValidationService service = org.eclipse.emf.validation.service.ModelValidationService.getInstance();
					org.eclipse.emf.validation.service.IBatchValidator validator = (org.eclipse.emf.validation.service.IBatchValidator) service.newValidator(org.eclipse.emf.validation.model.EvaluationMode.BATCH);
					validator.setIncludeLiveConstraints(true);
					org.eclipse.core.runtime.IStatus status = validator.validate(root);
					addStatus(status, root);
				} catch (Throwable t) {
					edapuC.resource.edapuC.mopp.EdapuCPlugin.logError("Exception while checking contraints provided by EMF validator classes.", t);
				}
			}
		}
	}
	
	private void addStatus(org.eclipse.core.runtime.IStatus status, org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> causes = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		causes.add(root);
		if (status instanceof org.eclipse.emf.validation.model.ConstraintStatus) {
			org.eclipse.emf.validation.model.ConstraintStatus constraintStatus = (org.eclipse.emf.validation.model.ConstraintStatus) status;
			java.util.Set<org.eclipse.emf.ecore.EObject> resultLocus = constraintStatus.getResultLocus();
			causes.clear();
			causes.addAll(resultLocus);
		}
		if (status.getSeverity() == org.eclipse.core.runtime.IStatus.ERROR) {
			for (org.eclipse.emf.ecore.EObject cause : causes) {
				addError(status.getMessage(), cause);
			}
		}
		if (status.getSeverity() == org.eclipse.core.runtime.IStatus.WARNING) {
			for (org.eclipse.emf.ecore.EObject cause : causes) {
				addWarning(status.getMessage(), cause);
			}
		}
		for (org.eclipse.core.runtime.IStatus child : status.getChildren()) {
			addStatus(child, root);
		}
	}
	
	public edapuC.resource.edapuC.IEdapuCQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(edapuC.resource.edapuC.IEdapuCOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
}

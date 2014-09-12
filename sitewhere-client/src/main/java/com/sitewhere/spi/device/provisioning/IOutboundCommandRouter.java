/*
 * IOutboundCommandRouter.java 
 * --------------------------------------------------------------------------------------
 * Copyright (c) Reveal Technologies, LLC. All rights reserved. http://www.reveal-tech.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.provisioning;

import java.util.List;

import com.sitewhere.spi.ISiteWhereLifecycle;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.IDeviceNestingContext;
import com.sitewhere.spi.device.command.IDeviceCommandExecution;

/**
 * Routes commands to one or more {@link IOutboundCommandAgent} implementations.
 * 
 * @author Derek
 */
public interface IOutboundCommandRouter extends ISiteWhereLifecycle {

	/**
	 * Initialize the router with agent information.
	 * 
	 * @param agents
	 * @throws SiteWhereException
	 */
	public void initialize(List<IOutboundCommandAgent<?>> agents) throws SiteWhereException;

	/**
	 * Route a command to one of the available agents.
	 * 
	 * @param execution
	 * @param nesting
	 * @param assignment
	 * @throws SiteWhereException
	 */
	public void routeCommand(IDeviceCommandExecution execution, IDeviceNestingContext nesting,
			IDeviceAssignment assignment) throws SiteWhereException;

	/**
	 * Route a system command to one of the available agents.
	 * 
	 * @param command
	 * @param nesting
	 * @param assignment
	 * @throws SiteWhereException
	 */
	public void routeSystemCommand(Object command, IDeviceNestingContext nesting, IDeviceAssignment assignment)
			throws SiteWhereException;
}
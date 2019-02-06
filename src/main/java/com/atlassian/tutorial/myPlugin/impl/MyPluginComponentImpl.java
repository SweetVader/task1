package com.atlassian.tutorial.myPlugin.impl;

import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel3;
import com.atlassian.jira.plugin.issuetabpanel.GetActionsRequest;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.ShowPanelRequest;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import com.atlassian.tutorial.myPlugin.api.MyPluginComponent;
import com.google.common.collect.Lists;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ExportAsService ({MyPluginComponent.class})
@Named ("myPluginComponent")
public class MyPluginComponentImpl implements MyPluginComponent {
    @ComponentImport
    private final ApplicationProperties applicationProperties;

    @Inject
    public MyPluginComponentImpl(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public String getName() {
        if (null != applicationProperties) {
            return "myComponent:" + applicationProperties.getDisplayName();
        }

        return "myComponent";
    }
}
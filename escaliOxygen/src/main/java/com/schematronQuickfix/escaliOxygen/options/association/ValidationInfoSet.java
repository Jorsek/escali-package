package com.schematronQuickfix.escaliOxygen.options.association;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.w3c.dom.Document;

import com.github.oxygenPlugins.common.xml.xpath.ProcessNamespaces;
import com.schematronQuickfix.escaliOxygen.editors.EscaliMessanger;
import com.schematronQuickfix.escaliOxygen.options.EscaliPluginConfig;
import com.schematronQuickfix.escaliOxygen.options.association.ValidationInfoSet.ValidationInfo;
import com.schematronQuickfix.escaliOxygen.options.association.table.AssociationRule;
import com.schematronQuickfix.escaliOxygen.options.association.table.AssociationRuleTable;
import com.schematronQuickfix.escaliOxygen.options.association.table.AssociationTable;
import com.schematronQuickfix.escaliOxygen.options.association.xmlModel.XmlModel;
import com.schematronQuickfix.escaliOxygen.options.association.xmlModel.XmlModelSet;
import com.schematronQuickfix.escaliOxygen.tools.WSPageAdapter;

import ro.sync.exml.workspace.api.editor.WSEditor;
import ro.sync.exml.workspace.api.editor.documenttype.DocumentTypeInformation;

public class ValidationInfoSet extends ArrayList<ValidationInfo> {
	private final URL editorLoc;

	public static class ValidationInfo {

		private final URL baseURL;
		private final URL schemaLocation;
		private String phase;
		private String lang;
		private final String title;

		private ValidationInfo(URL baseURL, URL schemaLocation, String phase,
				String lang, String title) {
			this.baseURL = baseURL;
			this.schemaLocation = schemaLocation;
			this.phase = phase;
			this.lang = lang;
			this.title = title;
		}

		private ValidationInfo(URL baseURL, URL schemaLocation, String phase,
				String lang) {
			this(baseURL, schemaLocation, phase, lang, "");
		}

		public void setPhase(String phase) {
			this.phase = phase;
		}

		public String getPhase() {
			return this.phase;
		}

		public URL getSchema() {
			return this.schemaLocation;
		}

		public String getBaseURI() {
			return this.baseURL.toString();
		}

	}

	public void add(XmlModel model) {
		ValidationInfo vi;
		try {
			vi = new ValidationInfo(this.editorLoc, model.getHref().toURI().toURL(),
					model.getPhase(), "#ALL");
			this.add(vi);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void add(AssociationRule rule) {
		ValidationInfo vi = new ValidationInfo(this.editorLoc,
				rule.getSchema(), rule.getPhaseSelectionValue(),
				rule.getLangSelectionValue());
		this.add(vi);
	}

	public ValidationInfoSet(URL editorLoc) {
		this.editorLoc = editorLoc;
	}

	public static ValidationInfoSet createValidationInfo(WSEditor editor,
			EscaliMessanger ema) {

		ValidationInfoSet validationSet = new ValidationInfoSet(
				editor.getEditorLocation());

		EscaliPluginConfig config = EscaliPluginConfig.config;
		WSPageAdapter pageAdapter = WSPageAdapter.getWSEditorAdapter(editor
				.getCurrentPage());
		
		
		if (config.isActive()) {
			AssociationRuleTable ruleTable = config.getRuleTable();
			Document docNode = pageAdapter.getDocument();
			
			AssociationRule schematronValidationRule = AssociationRule.getSchematronValidationRule(ema);
			DocumentTypeInformation docType = editor.getDocumentTypeInformation();
			String fwName = docType != null ? docType.getFrameworkStoreLocation() : AssociationTable.NULL_FRAMEWORK_LABEL;
			if(schematronValidationRule.match(editor.getEditorLocation(), docNode, fwName)){
				validationSet.add(schematronValidationRule);
			}
			
			if (config.useXmlModel()) {
				XmlModelSet modelSet = XmlModelSet.getXmlModelSet(editor, ema);
				ArrayList<XmlModel> models = modelSet
						.getModels(ProcessNamespaces.SCH_NS);
				for (XmlModel model : models) {
					validationSet.add(model);
				}
			}
			if (ruleTable.isActive()) {
				for (AssociationRule rule : ruleTable) {
					if (rule.match(editor.getEditorLocation(), docNode, fwName)) {
						validationSet.add(rule);
					}
				}

			}
		}

		return validationSet;
	}

	public static ValidationInfoSet createValidationInfo(URL url) {
		return new ValidationInfoSet(url);
	}

}

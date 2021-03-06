package com.xrosstools.xunit.editor.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.xrosstools.xunit.editor.model.CompositeUnitNode;
import com.xrosstools.xunit.editor.model.IconNode;
import com.xrosstools.xunit.editor.model.UnitNode;
import com.xrosstools.xunit.editor.model.UnitNodeConnection;
import com.xrosstools.xunit.editor.model.UnitNodeDiagram;
import com.xrosstools.xunit.editor.model.UnitNodeHelper;
import com.xrosstools.xunit.editor.model.UnitNodePanel;

public class UnitNodePartFactory implements EditPartFactory {
	private UnitNodeHelper helper;
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if(model == null)
			return part;
		
		if (model instanceof UnitNodeDiagram){
			if(helper == null)
				helper = new UnitNodeHelper((UnitNodeDiagram)model);
			part = new UnitNodeDiagramPart();
		}
		else if (model instanceof CompositeUnitNode)
			part = new CompositeUnitNodePart();
		else if (model instanceof UnitNodePanel)
			part = new UnitNodeContainerPart();
		else if (model instanceof IconNode)
			part = new IconNodePart();
		
		else if (model instanceof UnitNode)
			part = new UnitNodePart();

		else if (model instanceof UnitNodeConnection)
			part = new UnitNodeConnectionPart();

		if(model instanceof UnitNode){
			((UnitNode)model).setHelper(helper);
			((UnitNode)model).setPart(part);
		}
		
		part.setModel(model);
		
		return part;
	}
}

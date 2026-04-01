

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrgChartImpl implements OrgChart{

	//Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();

	@Override
	public void addRoot(Employee e) {
		// TODO Auto-generated method stub
		GenericTreeNode<Employee> rootEmployee = new GenericTreeNode<Employee>(e);
		nodes.add(rootEmployee);
	}

	@Override
	public void clear() {
		nodes.clear();
	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if (currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newEmployee = new GenericTreeNode<Employee>(newPerson);
				
				currentEmployee.addChild(newEmployee);
				nodes.add(newEmployee);
				
				break;
			}
		}
	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		if (nodes.isEmpty() || firedPerson == null) {
			return;
		}

		GenericTreeNode<Employee> firedNode = null;
		GenericTreeNode<Employee> parentNode = null;

		// Step 1 (started): find the node to remove and its parent.
		for (GenericTreeNode<Employee> possibleParent : nodes) {
			if (possibleParent.data.equals(firedPerson)) {
				firedNode = possibleParent;
			}
			for (GenericTreeNode<Employee> child : possibleParent.children) {
				if (child.data.equals(firedPerson)) {
					firedNode = child;
					parentNode = possibleParent;
					break;
				}
			}
			if (firedNode != null) {
				break;
			}
		}

		if (firedNode == null) {
			return;
		}

		// TODO Step 2: if firedNode is not root, move firedNode.children to parentNode.
		// TODO Step 3: remove firedNode from parentNode.children and from nodes list.
		// TODO Step 4: decide root-removal behavior (ignore, clear, or promote child).
	}

	@Override
	public void showOrgChartDepthFirst() {
		GenericTreeNode<Employee> rootEmployee = nodes.get(0);
		showOrgChartDepthFirst(rootEmployee);
	}
		
	private void showOrgChartDepthFirst(GenericTreeNode<Employee> e) {
		// TODO Auto-generated method stub
		if (e == null) {
			return;
		}

        // Visit the current node
        System.out.println("Current: " + e.data);
        System.out.println("--- ");

        // Recurse on each child left-to-right (pre-order)
        for (GenericTreeNode<Employee> child : e.children)
        {
        	showOrgChartDepthFirst(child);
        }
	}
	


	@Override
	public void showOrgChartBreadthFirst() {
		if (nodes.isEmpty()) {
			return;
		}

		Queue<GenericTreeNode<Employee>> queue = new LinkedList<>();
		queue.add(nodes.get(0));
		
		if (queue.isEmpty()) {
			return;
		}

		while (!queue.isEmpty()) {
			GenericTreeNode<Employee> current = queue.remove();
			System.out.println(current.data);

			for (int i = 0; i < current.children.size(); i++) {
				queue.add(current.children.get(i));
			}
		}
			
		
	}

	private void depthFirstPrint(GenericTreeNode<Employee> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		for (GenericTreeNode<Employee> child : node.children) {
			depthFirstPrint(child);
		}
	}
	
	
}

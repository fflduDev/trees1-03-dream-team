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

    /*finding fired node& parent */
    for (GenericTreeNode<Employee> node : nodes) {
        if (node.data.equals(firedPerson)) {
            firedNode = node;
        }

        for (GenericTreeNode<Employee> child : node.children) {
            if (child.data.equals(firedPerson)) {
                parentNode = node;
                firedNode = child;
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

    if (parentNode == null) {
        /*root node being removed */
        if (firedNode.children.isEmpty()) {
            nodes.remove(firedNode);
            return;
        }
        GenericTreeNode<Employee> newRoot = firedNode.children.get(0);
        for (int i = 1; i < firedNode.children.size(); i++) {
            GenericTreeNode<Employee> child = firedNode.children.get(i);
            newRoot.addChild(child);
        }

        nodes.remove(firedNode);
        nodes.remove(newRoot);
        nodes.add(0, newRoot);
        return;
    }

    /*child to parent */
    for (GenericTreeNode<Employee> child : firedNode.children) {
        parentNode.addChild(child); // properly add child using parent's method
    }

    firedNode.children.clear(); // remove references from fired node
    parentNode.removeChild(firedPerson);
    nodes.remove(firedNode);
}
	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub
		if (nodes.isEmpty()) return;
		depthFirstPrint(nodes.get(0));
	}

	private void depthFirstPrint(GenericTreeNode<Employee> node) {
		if (node == null) return;
		System.out.println(node.data);
		
		// Recurse on each child left-to-right (pre-order)
		for (GenericTreeNode<Employee> child : node.children) {
			depthFirstPrint(child);
		}
	}

	@Override
	public void showOrgChartBreadthFirst() {
		if (nodes.isEmpty()) return;

		Queue<GenericTreeNode<Employee>> queue = new LinkedList<>();
		queue.add(nodes.get(0));

		while (!queue.isEmpty()) {
			GenericTreeNode<Employee> current = queue.remove();
			System.out.println(current.data);

			for (GenericTreeNode<Employee> child : current.children) {
				queue.add(child);
			}
		}
	}
}
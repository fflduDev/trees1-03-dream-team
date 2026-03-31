

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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOrgChartBreadthFirst() {
		// TODO Auto-generated method stub
		
		Queue<GenericTreeNode<Employee>> queue = new LinkedList<>();
		queue.add(nodes.get(0));
		
		if (queue.isEmpty()) {
			return;
		}

		while (!queue.isEmpty()) {
			int n = queue.size();
			while (n > 0) {
				GenericTreeNode<Employee> current = queue.peek();
				queue.remove();
				System.out.println(current.data + " ");

				for (int i = 0; i < current.children.size(); i++) {
					queue.add(current.children.get(i));
				}
				n--;
			}
 			
			
			System.out.println();
		}
			
		
	}
	
	
}

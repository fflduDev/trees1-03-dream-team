
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children;
	
	public GenericTreeNode(E theItem) {
		data = theItem;
		children = new ArrayList<>();
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
		for (int i = 0; i < children.size(); i++) {
			GenericTreeNode<E> child = children.get(i);
			
			if (child.data.equals(theItem)) {
				children.remove(i);
				
				for (GenericTreeNode<E> grandChild : child.children) {
					children.add(i, grandChild);
					i++;
				}
				return;
			}
			
		}
	}
	
	
} 

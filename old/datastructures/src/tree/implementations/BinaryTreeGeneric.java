package tree.implementations;

public class BinaryTreeGeneric<X extends Comparable<X>> {

	private Node root;
	private int size;

	public BinaryTreeGeneric() {
		this.root = null;
	}

	public int size() {
		return size;
	}

	public void add(X item) {
		Node node = new Node(item);
		if (root == null) {
			this.root = node;
			System.out.println("Set root: ");
			size++;
		} else {
			insert(this.root, node);
		}
	}

	public boolean contains(X item) {
		Node curr = getNode(item);
		if (curr == null)
			return false;
		else
			return true;
	}

	public boolean delete(X item) {
		boolean deleted = false;
		if(this.root == null)
			return false;
		Node curr = getNode(item);
		if(curr != null) {
			if(curr.getLeft() == null && curr.getRight() == null) {
				unlink(curr, null);
				deleted = true;
			} else if (curr.getLeft() == null && curr.getRight() != null) {
				unlink(curr, curr.getRight());
				deleted = true;
			} else if(curr.getLeft() != null && curr.getRight() == null){
				unlink(curr, curr.getLeft());
				deleted = true;
			} else {
				Node child = curr.getLeft();
				while(child.getRight() != null && child.getLeft() != null) {
					child = child.getRight();
				}
				child.getParent().setRight(null);
				child.setLeft(curr.getLeft());
				child.setRight(curr.getRight());
				unlink(curr, child);
				deleted = true;
			}
		}
		if(deleted)
			size--;
		
		return deleted;
	}

	private void unlink(Node curr, Node newNode) {
		if(curr == this.root) {
			newNode.setLeft(curr.getLeft());
			newNode.setRight(curr.getRight());
			this.root = newNode;
		} else if (curr.getParent().getRight() == curr) {
			curr.getParent().setRight(newNode);
		} else {
			curr.getParent().setLeft(newNode);
		}
		
	}

	private Node getNode(X item) {
		Node curr = this.root;
		while (curr != null) {
			int val = item.compareTo(curr.getItem());
			if (val == 0)
				return curr;
			else if (val < 0)
				curr = curr.getLeft();
			else
				curr = curr.getRight();
		}
		return null;
	}

	public void insert(Node parent, Node child) {
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				size++;
			} else {
				insert(parent.getLeft(), child);
			}
		} else {
			if (parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				size++;
			} else {
				insert(parent.getRight(), child);
			}
		}
	}

	private class Node {
		private Node left;
		private Node right;
		private Node parent;
		private X item;

		public Node(X item) {
			this.left = null;
			this.right = null;
			this.parent = null;
			this.item = item;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

	}
}

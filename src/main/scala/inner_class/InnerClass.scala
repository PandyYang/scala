package inner_class

class Graph {
  class Node {
    var connectedNodes: List[Graph#Node] = Nil
    def connectTo(node: Graph#Node): Unit = {
      if (!connectedNodes.exists(node.equals)) {
        connectedNodes = node::connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res::nodes
    res
  }
}


object InnerClass {
  def main(args: Array[String]): Unit = {
    val graph1 = new Graph
    val node1 = graph1.newNode
    val node2 = graph1.newNode
    node1.connectTo(node2)
    val graph2 = new Graph
    val nodes3 = graph2.newNode
    node1.connectTo(nodes3)
  }
}

package LeetCode.DataStructure;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//��������
public class DirectedGraph {
	private class Vertex{
		private String v; //�����ʶ
		private LinkedList<Edge> adjEdges;
		private int inDegree; //�������
		
		public Vertex(String startNodeLabel){
			this.v = startNodeLabel;
			inDegree = 0;
			adjEdges = new LinkedList<Edge>();
		}
	}
	
	private class Edge{
		private Vertex endVertex; //�ߵĽ�����
		public Edge (Vertex endVertex) {
			this.endVertex = endVertex;
		}
	}
	
	private Map<String, Vertex> DG;
	
	public DirectedGraph(String graphContent) {
		DG = new LinkedHashMap<String, Vertex>();
		buildGraph(graphContent);
	}
	
	private void buildGraph(String graphContent) {
		String[] lines = graphContent.split("\n");
		Vertex startNode, endNode;
		String startNodeLabel, endNodeLabel;
		Edge e;
		for (int i = 0; i < lines.length; i++) {
			String[] nodesInfo = lines[i].split(",");
			startNodeLabel = nodesInfo[1];
			endNodeLabel = nodesInfo[2];
			startNode = DG.get(startNodeLabel);
			if(startNode == null){
                 startNode = new Vertex(startNodeLabel);
                 DG.put(startNodeLabel, startNode);
             }
             endNode = DG.get(endNodeLabel);
             if(endNode == null){
                 endNode = new Vertex(endNodeLabel);
                 DG.put(endNodeLabel, endNode);
             }
             
             e = new Edge(endNode);//ÿ����һ�д���һ����
             startNode.adjEdges.add(e);//ÿ����һ������,��ʼ�������һ����
             endNode.inDegree++;//ÿ����һ������,��ֹ������ȼ�1
         }
	}
	
	public void topoSort() throws Exception{
         int count = 0;
         
         Queue<Vertex> queue = new LinkedList<>();// �����������õ���ջ,Ҳ���ö���.
         //ɨ�����еĶ���,�����Ϊ0�Ķ��������
         Collection<Vertex> vertexs = DG.values();
         for (Vertex vertex : vertexs)
             if(vertex.inDegree == 0)
                 queue.offer(vertex);
         
         while(!queue.isEmpty()){
             Vertex v = queue.poll();
             System.out.print(v.v + " ");
            count++;
             for (Edge e : v.adjEdges) 
                 if(--e.endVertex.inDegree == 0)
                     queue.offer(e.endVertex);
         }
         if(count != DG.size())
             throw new Exception("Graph has circle");
     }
}

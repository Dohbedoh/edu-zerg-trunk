/**
 * Class Graph: Represents an directed acyclic graph (DAG) that consists in many nodes related
 * by edges. The edges are represented by an adjacent matrix.
 * 
 * @author Allan BURDAJEWICZ
 */

package com.csse7034.zerg.c1.sorting;

import java.util.Vector;


public class Graph implements GraphI{

	/** Array of all nodes in the graph */
	private NodeI [] nodes;
	
	/** Matrix that represents the graph*/
	private int [][] edges;
	
	/** The size of the graph or the number of node */
	private int size;
	
	/** Array of all nodes that have been visited (cycle detection)*/
	private boolean[] visited;
	
	public Graph()
	{
		size = 0;
		nodes = new NodeI[50];
		edges = new int [50][50];
		for(int i=0; i<edges.length; i++)
		{
			for(int j=0; j<edges[i].length;j++)
			{
				edges[i][j] = 0;
			}
		}
	}
	
	/**
	 * Find the maximum level of a node in the Graph
	 * @param node	The index of the node
	 * @return the maximum level of the node
	 */
	private int findLevel(int node)
	{
		int max = nodes[node].getLevel();
		for(int i=0; i<size; i++)
		{
			if(edges[i][node]==1)
			{
				max = Math.max(max, nodes[i].getLevel());
			}
		}
		return max+1;
	}
	
	/**
	 * Adjust the level of the nodes in the graph, starting from a particular node whose
	 * the level is known
	 * @param node		node from which the levelling start
	 * @param level		the max level of the node
	 */
	private void adjustLevelFrom(int node, int level)
	{
		for(int i=0; i<size; i++)
		{
			if(edges[node][i]==1)
			{
				if(nodes[node].getLevel()>nodes[i].getLevel())
				{
					int newLevel = findLevel(i);
					nodes[i].setLevel(newLevel);
					adjustLevelFrom(i,newLevel);
				}else{
					if(nodes[node].getLevel()==nodes[i].getLevel())
					{
						nodes[i].setLevel(level+1);
						adjustLevelFrom(i,level+1);
					}
				}
			}
		}
	}
	
	/**
	 * Return if the graph contains a cycle between a node source and a node destination
	 * @param src		The source node
	 * @param dest		The destination node
	 * @return			The graph contains a cycle
	 */
	private boolean containsCycle(int src, int dest)
	{
		boolean[] visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			visited[i] = false;
		}
		visited[dest] = true;
		for(int i=0; i<size; i++)
		{
			if(edges[src][i]==1)
			{
				if(visit(i))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Find if a node has already been visited (during the cycle detection)
	 * @param node		The node to test
	 * @return			The node has already been visited
	 */
	private boolean visit(int node)
	{
		visited[node] = true;
		for(int i=0; i<size; i++)
		{
			if(edges[node][i]==1)
			{
				if(visited[i])
				{
					return true;
				}else{
					return visit(i);
				}
			}
		}
		return false;
	}

	/**
	 * Resize the matrix of edges and the array of nodes when required
	 */
	private void resize()
	{
		NodeI[] tempNodes = new NodeI[nodes.length*2];
		int [][] tempEdges = new int [nodes.length*2][nodes.length*2];
		for(int i=0; i<size; i++)
		{
			tempNodes[i] = nodes[i];
			for(int j=0; i<size;i++)
			{
				tempEdges[i][j] = edges[i][j];
			}
		}
		for(int i=size; i<edges.length; i++)
		{
			for(int j=size; j<edges[i].length;j++)
			{
				edges[i][j] = 0;
			}
		}
		nodes = tempNodes;
		edges = tempEdges;
	}

	@Override
	public void addNode(String name) {
		if(size==nodes.length)
		{
			resize(); 
		}
		nodes[size] = new Node(name);
		size++;
	}


	@Override
	public String addEdge(String src, String dest) {
		if(src!=dest)
		{
			int indSrc=-1, indDest=-1, i=0;
			while(i<size || (indSrc == -1 && indDest == -1))
			{
				if(nodes[i].getName().equals(src))
				{
					indSrc = i;
				}else{
					if(nodes[i].getName().equals(dest))
					{
						indDest = i;
					}
				}
				i++;
			}
			
			if(edges[indSrc][indDest] == -1 || containsCycle(indDest, indSrc))
			{
				return ("Error Code 3: Cyclic");
			}

			int levelDest = findLevel(indDest);
			nodes[indDest].setLevel(levelDest);
			adjustLevelFrom(indDest,levelDest);
			
			edges[indSrc][indDest] = 1;
			edges[indDest][indSrc] = -1;
			return ("ok");
		}else{
			return ("Error Code 3: Cyclic");
		}
	}


	@Override
	public int getDepth() {
		int max=0;
		for(int i=0; i<size; i++)
		{
			max = Math.max(nodes[i].getLevel(),max);
		}
		return max;
	}


	@Override
	public NodeI[] getNodesAtLevel(int level) {
		Vector<NodeI> temp = new Vector<NodeI>();
		for(int i=0; i<size; i++)
		{
			if(nodes[i].getLevel()==level)
			{
				temp.add(nodes[i]);
			}
		}
		NodeI [] res = new NodeI [temp.size()];
		for(int i=0; i<temp.size(); i++)
		{
			res[i]=temp.get(i);
		}
		return res;
	}


	@Override
	public boolean contains(String name) {		
		return indexOf(name)!=-1;
	}


	@Override
	public int indexOf(String name) {
		for(int i=0; i<size; i++)
		{
			if(nodes[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * Return a String representation of the graph
	 * @return		A String representation of the Graph
	 */
	public String toString()
	{
		StringBuffer buffer = new StringBuffer("Graph Representation:\n\n");
		for(int i=0; i<size; i++)
		{	
			buffer.append(nodes[i].getName() + ": ");
			for(int j=0; j<size; j++)
			{
				if(edges[i][j]==1)
				{
					buffer.append(nodes[j].getName());
					buffer.append("("+(nodes[j].getLevel())+")");
				}
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}
}

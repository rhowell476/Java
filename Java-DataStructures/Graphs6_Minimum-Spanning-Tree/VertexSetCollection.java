import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

// Stores a collection of vertex sets that collectively store all vertices in a 
// graph. Each vertex is in only one set in the collection.
class VertexSetCollection {
   private HashMap<Vertex, HashSet<Vertex>> vertexMap;
   
   public VertexSetCollection(Collection<Vertex> allVertices) {
      vertexMap = new HashMap<Vertex, HashSet<Vertex>>();
      for (Vertex vertex : allVertices) {
         HashSet<Vertex> vertexSet = new HashSet<Vertex>();
         vertexSet.add(vertex);
         vertexMap.put(vertex, vertexSet);
      }
   }
   
   // Gets the set containing the specified vertex
   public HashSet<Vertex> getSet(Vertex vertex) {
      return vertexMap.get(vertex);
   }

   // Merges two distinct sets from the collection. Remaps each vertex from the 
   // two sets to the merged set.   
   public void merge(HashSet<Vertex> vertexSet1, HashSet<Vertex> vertexSet2) {
      // First create the union
      HashSet<Vertex> merged = new HashSet<Vertex>(vertexSet1);
      merged.addAll(vertexSet2);
      
      // Now remap all vertices in the merged set
      for (Vertex vertex : merged) {
         vertexMap.put(vertex, merged);
      }
   }
}
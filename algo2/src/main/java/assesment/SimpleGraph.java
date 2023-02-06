import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value)
    {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                break;
            }
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
        // ваш код удаления вершины со всеми её рёбрами
        vertex[v] = null;
        for (int i = 0; i < m_adjacency.length; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }

    }

    public boolean IsEdge(int v1, int v2)
    {
        // true если есть ребро между вершинами v1 и v2
        return m_adjacency[v1][v2] == 1 || m_adjacency[v2][v1] == 1;
    }

    public void AddEdge(int v1, int v2)
    {
        // добавление ребра между вершинами v1 и v2
        if (isIndexCorrect(v1) && isIndexCorrect(v2)) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }

    }

    public void RemoveEdge(int v1, int v2)
    {
        // удаление ребра между вершинами v1 и v2
        if (isIndexCorrect(v1) && isIndexCorrect(v2)) {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }

    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        hitFalse();
        ArrayDeque<Integer> hittedVertices = new ArrayDeque<>();

        vertex[VFrom].Hit = true;
        hittedVertices.push(VFrom);
        int currentIndex = VFrom;

        for (int i = 0; i < vertex.length; i++) {
            if (m_adjacency[currentIndex][VTo] == 1) {
                hittedVertices.push(VTo);
                break;
            }
            boolean shouldGoNext = false;
            for (int j = 0; j < max_vertex; j++) {
                if (m_adjacency[currentIndex][j] == 1 && !vertex[j].Hit) {
                    vertex[j].Hit = true;
                    hittedVertices.push(j);
                    currentIndex = j;
                    shouldGoNext = true;
                    break;
                }
            }
            if (!shouldGoNext) {
                hittedVertices.pop();
                if (hittedVertices.isEmpty()) {
                    return new ArrayList<>();
                }
                currentIndex = hittedVertices.peek();
            }
        }

        ArrayList<Vertex> path = new ArrayList<>();
        while (!hittedVertices.isEmpty()) {
            path.add(vertex[hittedVertices.pollLast()]);
        }

        return path;
    }

    private void hitFalse() {
        for (Vertex value : vertex) {
            value.Hit = false;
        }
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index < max_vertex;
    }
}
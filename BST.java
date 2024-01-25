
import java.util.ArrayList;

/**
 *
 * @author Lucas Mendes
 */
public class BST {
    public Node createNode(String name){ //Cria novo node
        Node node = new Node();
        node.setNome(name);
        node.setLeft(null);
        node.setRight(null);
        
        return node;
        
    }
    public Node insert(Node node, String name){ //Insere recursivamente na arvore
        if(node == null){
            return createNode(name); // Se o nó for nulo(raiz) então criamos um com esse valor
        }
        if(name.compareTo(node.getNome()) < 0){ //Se compareTo retornar numero positivo significa que name é maior, logo node fica à esquerda
            Node a = insert(node.getLeft(), name);
            node.setLeft(a);
        }
        else if(name.compareTo(node.getNome()) > 0){ //Se compareTo retornar numero negativo significa que name é menor, logo node ficará à direita
            Node a = insert(node.getRight(),name);
            node.setRight(a);
        }
        return node;
    }
    
    public int size(Node node){
        if (node == null ){
            return 0 ;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }
    public int heigth(Node node){
        if(node == null){
            return 0; //Arvore vazia
        }
        int leftHeigth = heigth(node.getLeft()); //Calcula tamanho esquerdo
        int rightHeigth = heigth(node.getRight()); // Calcula tamanho direito
        
        if (leftHeigth > rightHeigth){ //Vê qual lado é maior
            return leftHeigth+1;
        } else{
            return rightHeigth+1;
        }
        
    }
    public String minor(Node node){ //Mostra o menor item, que no caso é o mais a esquerda
        if (node == null){
            return "Arvore vazia";
        }
        while(node.getLeft() != null){ //Percorre toda a esquerda
            node = node.getLeft();
        }
        return node.getNome().toLowerCase();
    }
    public String greater(Node node){ //Mostra o maior item, no caso o mais a direita
        if (node == null){
            return "Arvore vazia";
        }
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node.getNome().toLowerCase();
    }
    
    public int InternalPathLength(Node node){ //Sobrecarga de metodo para não precisar especificar parametro de profundidade
        return InternalPathLength(node,0);
    }
    public int InternalPathLength(Node node, int depth){ //Depth - profundidade || Chamada recursiva faz com que a profuniadade aumente em cada execução
        if(node == null){
            return 0;
        }
        int atualDepht = depth;
        
        atualDepht += InternalPathLength(node.getLeft(), depth + 1); //Lado esquerdo
        atualDepht += InternalPathLength(node.getRight(), depth +1); //Lado direito
        
        
        return atualDepht;
    }
    public boolean isBalanced( Node node){ //Verifica se a arvore está balanceada ou não.
        if(node == null){
            return true;
        }
        int balance = heigth(node.getLeft()) - heigth(node.getRight());
        if (balance<0){ //Pega valor absoluto
            balance = -balance;
        }
        if(balance>1){
            return false;
        }
        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }
    public ArrayList<String> preOrder(Node node){ // Root - left - right
        if(isEmpty(node)){
            return null; //!!!Trocar por expetion!!!!
        }
        ArrayList<String> nomes = new ArrayList();
        nomes.add(node.getNome());
        
        if(node.getLeft() != null){
            nomes.addAll(preOrder(node.getLeft()));
        }
        if(node.getRight()!= null){
            nomes.addAll(preOrder(node.getRight()));
        }
        
        return nomes;
        
    }
    public ArrayList <String> inOrder(Node node){ //Left - Root - right
        if(isEmpty(node)){
           return null;
        }
         ArrayList<String> nomes = new ArrayList();
          if(node.getLeft() != null){
            nomes.addAll(inOrder(node.getLeft()));
        }
          
        nomes.add(node.getNome());
        
        if(node.getRight()!= null){
            nomes.addAll(inOrder(node.getRight()));
        }
        return nomes;
    }
    public ArrayList <String> postOrder(Node node){ //left - right - root
        if(node == null){
            return null;
        }
        ArrayList <String> nomes = new ArrayList();
        
        if(node.getLeft()!= null){
           nomes.addAll(postOrder(node.getLeft())); 
        }
        
        
        if(node.getRight()!= null){
            nomes.addAll(postOrder(node.getRight()));
        }
        nomes.add(node.getNome());
        
        return nomes;
        
    }
    
    public ArrayList<String> levelOrder(Node node) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        levelOrder(node, 0, result);
        ArrayList<String> listaFinal = combineLists(result);
        return listaFinal;
    }
      private static ArrayList<String> combineLists(ArrayList<ArrayList<String>> result) {
        ArrayList<String> combinedList = new ArrayList<>();

        for (ArrayList<String> level : result) {
            combinedList.addAll(level);
        }

        return combinedList;
    }

    private void levelOrder(Node node, int depth, ArrayList<ArrayList<String>> result) {
        if (node == null) {
            return;
        }

        if (depth == result.size()) {
            // Criar uma nova lista para o próximo nível
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.getNome());

        // Chamadas recursivas para os filhos
        levelOrder(node.getLeft(), depth + 1, result);
        levelOrder(node.getRight(), depth + 1, result);
    }
    
    
    public boolean isEmpty(Node node){
        if(node == null){
            return true;
        } else{
            return false;
        }
        
    }
}


/**
 *
 * @author Lucas Mendes
 */
public class Node {
    private String nome;
    private Node left; //Esquerda
    private Node right; //Direita
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setRight(Node right){
        this.right = right;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public String getNome(){
        return nome;
    }
    public Node getRight(){
        return right;
    }
    public Node getLeft(){
        return left;
    }
}

public class Aeroporto {

    private String nome; //nome do Aeroporto
    private String codigo; //código do Aeroporto

    public String getNome(){
        return this.nome;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void setNome(String nome) throws Exception{

        if(nome==null || nome.length()==0)
            throw new Exception("Nome ausente");
        
        this.nome = nome;
    }

    public void SetCodigo(String codigo) throws Exception{

        if(codigo==null || codigo.length()==0)
            throw new Exception("Codigo ausente");
    }

    //Construtor da Classe
    public Aeroporto (String nome, String codigo) throws Exception
    {
        this.setNome(nome);
        this.SetCodigo(codigo);
    }

    public Aeroporto(){}

    public String toString()
    {
        return "Nome Aeroporto: " + this.nome + "Codigo Aeroporto: " + this.codigo;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;
        
        if (obj==null)
            return false;

        if (!(obj instanceof Aeroporto))
            return false;

        Aeroporto aeroporto = (Aeroporto)obj;

        if (this.nome.equals(aeroporto.nome))
            return false;

        if (this.codigo.equals(aeroporto.codigo))
            return false;

        return true;
    }

    public int hasCode()
    {
        int ret=12;

        ret = 2*ret + this.nome   .hashCode();
        ret = 2*ret + this.codigo .hashCode();

        return ret;
    }

}

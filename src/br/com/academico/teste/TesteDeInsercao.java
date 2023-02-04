package br.com.academico.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.academico.jdbc.FabricaDeConexoes;

public class TesteDeInsercao {

  public static void main(String[] args) {
    try {
      Connection con = FabricaDeConexoes.pegarConexao();

      String vCpf = "1";
      String vNome = "Henzo";
      
      String sql = "insert into tbaluno (cpf, nome) values (?, ?)";

      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, vCpf);
      stmt.setString(2, vNome);
      stmt.execute();

      System.out.println("Inserido por parâmetros");
      FabricaDeConexoes.encerrarRecursosBD(con, stmt);
    } catch (Exception e) {
      System.err.println("Erro no banco de dados: " + "\n" + 
          e.getMessage() + "\n" + 
          e.getClass());
//      e.printStackTrace();
    }
  }
}

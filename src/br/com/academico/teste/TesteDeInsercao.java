package br.com.academico.teste;

import java.sql.Connection;
import java.sql.Statement;

import br.com.academico.jdbc.FabricaDeConexoes;

public class TesteDeInsercao {

  public static void main(String[] args) {
    try {
      Connection con = FabricaDeConexoes.pegarConexao();

      String vCpf = "1";

      String sql = "insert into tbaluno (cpf) values ('" + vCpf + "')";

      Statement stmt = con.createStatement();
      stmt.execute(sql);

      System.out.println("Inserido");
      FabricaDeConexoes.encerrarRecursosBD(con, stmt);
    } catch (Exception e) {
      System.err.println("Erro no banco de dados: " + "\n" + 
          e.getMessage() + "\n" + 
          e.getClass());
//      e.printStackTrace();
    }
  }
}

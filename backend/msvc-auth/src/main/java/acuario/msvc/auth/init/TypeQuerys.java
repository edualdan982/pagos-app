package acuario.msvc.auth.init;

public enum TypeQuerys {
  SEQ_NOCACHE("select sequence_owner,sequence_name from dba_sequences WHERE sequence_owner=?1 AND cache_size > 0"),
  ALTER_NOCACHE("alter sequence %s nocache");

  private String query;

  private TypeQuerys(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

}

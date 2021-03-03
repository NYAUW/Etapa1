package br.contmatic.type;

public enum EstadosType {

	RO(11,"Rondônia", "Brasil"),
	AC(12,"Acre", "Brasil"),
	AM(13,"Amazonas", "Brasil"),
	RR(14,"Roraima", "Brasil"),
	PA(15,"Pará", "Brasil"),
	AP(16,"Amapá", "Brasil"),
	TO(17,"Tocantins", "Brasil"),
	MA(21,"Maranhão", "Brasil"),
	PI(22,"Piauí", "Brasil"),
	CE(23,"Ceará", "Brasil"),
	RN(24,"Rio Grande do Norte", "Brasil"),
	PB(25,"Paraíba", "Brasil"),
	PE(26,"Pernambuco", "Brasil"),
	AL(27,"Alagoas", "Brasil"),
	SE(28,"Sergipe", "Brasil"),
	BA(29,"Bahia", "Brasil"),
	MG(31,"Minas Gerais", "Brasil"),
	ES(32,"Espírito Santo", "Brasil"),
	RJ(33,"Rio de Janeiro", "Brasil"),
	SP(35,"São Paulo", "Brasil"),
	PR(41,"Paraná", "Brasil"),
	SC(42,"Santa Catarina", "Brasil"),
	RS(43,"Rio Grande do Sul", "Brasil"),
	MS(50,"Mato Grosso do Sul", "Brasil"),
	MT(51,"Mato Grosso", "Brasil"),
	GO(52,"Goiás", "Brasil"),
	DF(53,"Distrito Federal", "Brasil");

	private final int codigoIbge;
	
	private final String nome;
	
	private final String pais;

	private EstadosType(int codigoIbge,String nome, String pais) {
		this.codigoIbge = codigoIbge;
		this.nome = nome;
		this.pais = pais;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getCodigoIbge(){
		return codigoIbge;
	}

	public String getPais() {
		return pais;
	}
	
	
	
}

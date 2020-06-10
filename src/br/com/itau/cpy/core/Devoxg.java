package br.com.itau.cpy.core;

import java.awt.List;
import java.util.ArrayList;

import br.com.itau.cpy.model.Field;
import br.com.wipro.cpyjavacore.api.annotation.CopyBook;

@CopyBook(totalBytes = "1598", name = "DEVOXG")
public class Devoxg {

	@br.com.wipro.cpyjavacore.api.annotation.Field(order = "1", name = "AGENCIA-TRAG", parent = "MENSAGEM-SAIDA", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
	private String agenciaTrag;

	@br.com.wipro.cpyjavacore.api.annotation.Field(order = "2", name = "CENTRALIZADORA-TRAG", parent = "MENSAGEM-SAIDA", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
	private String centralizadoraTrag;

	@br.com.wipro.cpyjavacore.api.annotation.Field(order = "3", name = "QTDE-REGS-BLOCO", parent = "MENSAGEM-SAIDA", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
	private String qtdeRegsBloco;

	@br.com.wipro.cpyjavacore.api.annotation.List(order = "4", dependsOccurs = null, dependsType = "NUMBER", dependsValues = "", maxOccurs = "30", minOccurs = "30", name = "AREA-CHEQUES", parent = "MENSAGEM-SAIDA")
	private java.util.List<AreaCheques> areaCheques = new ArrayList<AreaCheques>();;

	public void setAgenciaTrag(String agenciaTrag) {
		this.agenciaTrag = agenciaTrag;
	}

	public String getAgenciaTrag() {
		return agenciaTrag;
	}

	public void setCentralizadoraTrag(String centralizadoraTrag) {
		this.centralizadoraTrag = centralizadoraTrag;
	}

	public String getCentralizadoraTrag() {
		return centralizadoraTrag;
	}

	public void setQtdeRegsBloco(String qtdeRegsBloco) {
		this.qtdeRegsBloco = qtdeRegsBloco;
	}

	public String getQtdeRegsBloco() {
		return qtdeRegsBloco;
	}

	public void setAreaCheques(java.util.List<AreaCheques> areaCheques) {
		this.areaCheques = areaCheques;
	}

	public void addAreaCheques(AreaCheques areaCheques) {
		this.areaCheques.add(areaCheques);
	}

	public java.util.List<AreaCheques> getAreaCheques() {
		return areaCheques;
	}

	public AreaCheques getAreaCheques(int index) {
		return this.areaCheques.get(index);
	}

	public static class AreaCheques {
		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "1", name = "CONTA-TRAG", parent = "AREA-CHEQUES", pic = "9(13)", type = "NUMERIC", bytes = "7", dependsType = "NUMBER", length = "13", usage = "COMP_3", sign = "NONE")
		private String contaTrag;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "2", name = "NUMERO-CHEQUE", parent = "AREA-CHEQUES", pic = "9(07)", type = "NUMERIC", bytes = "4", dependsType = "NUMBER", length = "7", usage = "COMP_3", sign = "NONE")
		private String numeroCheque;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "3", name = "VALOR", parent = "AREA-CHEQUES", pic = "9(13)V99", type = "NUMERIC", bytes = "8", decimals = "2", dependsType = "NUMBER", length = "15", usage = "COMP_3", sign = "NONE")
		private String valor;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "4", name = "CODIGO-LANCAMENTO", parent = "AREA-CHEQUES", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
		private String codigoLancamento;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "5", name = "BANCO-ENDOSSANTE", parent = "AREA-CHEQUES", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
		private String bancoEndossante;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "6", name = "LOTE", parent = "AREA-CHEQUES", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
		private String lote;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "7", name = "NUMERO-SEQUENCIAL", parent = "AREA-CHEQUES", pic = "9(09)", type = "NUMERIC", bytes = "5", dependsType = "NUMBER", length = "9", usage = "COMP_3", sign = "NONE")
		private String numeroSequencial;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "8", name = "MOTIVO", parent = "AREA-CHEQUES", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
		private String motivo;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "9", name = "MOTIVO-ANTERIOR", parent = "AREA-CHEQUES", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
		private String motivoAnterior;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "10", name = "MOTIVO-AUTOMATICO", parent = "AREA-CHEQUES", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
		private String motivoAutomatico;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "11", name = "CODIGO-CLASS-CHEQUE", parent = "AREA-CHEQUES", pic = "9(02)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "2", usage = "COMP_3", sign = "NONE")
		private String codigoClassCheque;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "12", name = "MARCA-CHEQUE", parent = "AREA-CHEQUES", pic = "X(01)", type = "ALPHANUM", bytes = "1", dependsType = "NUMBER", length = "1", usage = "DISPLAY", sign = "NONE")
		private String marcaCheque;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "13", name = "AGENCIA-ORIGEM", parent = "AREA-CHEQUES", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
		private String agenciaOrigem;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "14", name = "CONTA-ORIGEM", parent = "AREA-CHEQUES", pic = "9(07)", type = "NUMERIC", bytes = "4", dependsType = "NUMBER", length = "7", usage = "COMP_3", sign = "NONE")
		private String contaOrigem;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "15", name = "POLO-ORIGEM", parent = "AREA-CHEQUES", pic = "9(05)", type = "NUMERIC", bytes = "3", dependsType = "NUMBER", length = "5", usage = "COMP_3", sign = "NONE")
		private String poloOrigem;

		@br.com.wipro.cpyjavacore.api.annotation.Field(order = "16", name = "CIDTFD-FRAUDE", parent = "AREA-CHEQUES", pic = "9(03)", type = "NUMERIC", bytes = "2", dependsType = "NUMBER", length = "3", usage = "COMP_3", sign = "NONE")
		private String cidtfdFraude;

		public void setContaTrag(String contaTrag) {
			this.contaTrag = contaTrag;
		}

		public String getContaTrag() {
			return contaTrag;
		}

		public void setNumeroCheque(String numeroCheque) {
			this.numeroCheque = numeroCheque;
		}

		public String getNumeroCheque() {
			return numeroCheque;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		}

		public void setCodigoLancamento(String codigoLancamento) {
			this.codigoLancamento = codigoLancamento;
		}

		public String getCodigoLancamento() {
			return codigoLancamento;
		}

		public void setBancoEndossante(String bancoEndossante) {
			this.bancoEndossante = bancoEndossante;
		}

		public String getBancoEndossante() {
			return bancoEndossante;
		}

		public void setLote(String lote) {
			this.lote = lote;
		}

		public String getLote() {
			return lote;
		}

		public void setNumeroSequencial(String numeroSequencial) {
			this.numeroSequencial = numeroSequencial;
		}

		public String getNumeroSequencial() {
			return numeroSequencial;
		}

		public void setMotivo(String motivo) {
			this.motivo = motivo;
		}

		public String getMotivo() {
			return motivo;
		}

		public void setMotivoAnterior(String motivoAnterior) {
			this.motivoAnterior = motivoAnterior;
		}

		public String getMotivoAnterior() {
			return motivoAnterior;
		}

		public void setMotivoAutomatico(String motivoAutomatico) {
			this.motivoAutomatico = motivoAutomatico;
		}

		public String getMotivoAutomatico() {
			return motivoAutomatico;
		}

		public void setCodigoClassCheque(String codigoClassCheque) {
			this.codigoClassCheque = codigoClassCheque;
		}

		public String getCodigoClassCheque() {
			return codigoClassCheque;
		}

		public void setMarcaCheque(String marcaCheque) {
			this.marcaCheque = marcaCheque;
		}

		public String getMarcaCheque() {
			return marcaCheque;
		}

		public void setAgenciaOrigem(String agenciaOrigem) {
			this.agenciaOrigem = agenciaOrigem;
		}

		public String getAgenciaOrigem() {
			return agenciaOrigem;
		}

		public void setContaOrigem(String contaOrigem) {
			this.contaOrigem = contaOrigem;
		}

		public String getContaOrigem() {
			return contaOrigem;
		}

		public void setPoloOrigem(String poloOrigem) {
			this.poloOrigem = poloOrigem;
		}

		public String getPoloOrigem() {
			return poloOrigem;
		}

		public void setCidtfdFraude(String cidtfdFraude) {
			this.cidtfdFraude = cidtfdFraude;
		}

		public String getCidtfdFraude() {
			return cidtfdFraude;
		}
	}
}

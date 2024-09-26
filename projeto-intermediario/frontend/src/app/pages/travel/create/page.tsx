'use client'

import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { Container, ContainerBtn, ContainerInput, ContainerMain, ContainerOrcamento, Divisor, FieldGroup, Form, InputGroup } from "./style";

interface IniciarViagem {
  idUser: string;
  localViagem: string;
  localHospedagem: string;
  dataInicio: string;
  dataFim: string;
  valorPassagem: string;
  valorHospedagem: string;
  valorConsumo: string;
  valorTotal: string;
}

export default function IniciarViagem() {
  const [idUser, setIdUser] = useState<string>("");
  const [localViagem, setLocalViagem] = useState<string>("");
  const [localHospedagem, setLocalHospedagem] = useState<string>("");
  const [dataInicio, setDataInicio] = useState<string>("");
  const [dataFim, setDataFim] = useState<string>("");
  const [valorPassagem, setValorPassagem] = useState<string>("");
  const [valorHospedagem, setValorHospedagem] = useState<string>("");
  const [valorConsumo, setValorConsumo] = useState<string>("");
  const [valorTotal, setValorTotal] = useState<string>("");
  const router = useRouter();

  useEffect(() => {
    const account: string | null = sessionStorage.getItem("remeberAccount");
    if (account) {
      setIdUser(account);
      setIdUser("");
    }
  }, []);

  const handleSubmitViagem = async (e: React.FormEvent) => {
    e.preventDefault();

    const convertToNumber = (valor: string) => {
      return parseFloat(valor.replace("R$", "").replace(/\./g, "").replace(",", "."));
    };

    const valorPassagemNum = convertToNumber(valorPassagem);
    const valorHospedagemNum = convertToNumber(valorHospedagem);
    const valorConsumoNum = convertToNumber(valorConsumo);

    const valorTotalCalculado = valorPassagemNum + valorHospedagemNum + valorConsumoNum;
    setValorTotal('R$ ' + valorTotalCalculado.toFixed(2));

    try {
      const response = await fetch("http://localhost:8080/api/viagens/iniciar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          idUser: idUser,
          localViagem: localViagem,
          localHospedagem: localHospedagem,
          dataInicio: dataInicio,
          dataFim: dataFim,
          valorPassagem: valorPassagemNum,
          valorHospedagem: valorHospedagemNum,
          valorConsumo: valorConsumoNum,
          valorTotal: valorTotalCalculado,
        }),
      });

      if (response.ok) {
        router.push("/");
      } else {
        alert("Erro ao iniciar viagem!");
      }
    } catch (error) {
      alert("Erro ao iniciar viagem");
    }
  };

  const handleFormatarMoeda = (
    e: React.ChangeEvent<HTMLInputElement>,
    setState: React.Dispatch<React.SetStateAction<string>>
  ) => {
    let value = e.target.value;
    value = value.replace(/\D/g, "");
    value = (Number(value) / 100).toLocaleString("pt-BR", {
      style: "currency",
      currency: "BRL",
    });
    setState(value);
  };

  const handleCancel = () => {
    router.push("/");
  };

  return (
    <>
      <ContainerMain>
        <Container>
          <Form onSubmit={handleSubmitViagem}>
            <FieldGroup>
              <InputGroup>
                <ContainerInput>
                  <label htmlFor="localViagem">Local da Viagem</label>
                  <input
                    id="localViagem"
                    type="text"
                    autoComplete="off"
                    required
                    value={localViagem}
                    onChange={(e) => setLocalViagem(e.target.value)}
                  />
                </ContainerInput>
                <ContainerInput>
                  <label htmlFor="localHospedagem">Local da Hospedagem</label>
                  <input
                    id="localHospedagem"
                    type="text"
                    autoComplete="off"
                    required
                    value={localHospedagem}
                    onChange={(e) => setLocalHospedagem(e.target.value)}
                  />
                </ContainerInput>
              </InputGroup>
              <InputGroup>
                <ContainerInput>
                  <label htmlFor="dataInicio">Data Início</label>
                  <input
                    id="dataInicio"
                    type="date"
                    autoComplete="off"
                    required
                    value={dataInicio}
                    onChange={(e) => setDataInicio(e.target.value)}
                  />
                </ContainerInput>
                <ContainerInput>
                  <label htmlFor="dataFim">Data Fim</label>
                  <input
                    id="dataFim"
                    type="date"
                    autoComplete="off"
                    required
                    value={dataFim}
                    onChange={(e) => setDataFim(e.target.value)}
                  />
                </ContainerInput>
              </InputGroup>
            </FieldGroup>

            <ContainerOrcamento>
              <span></span>
              <p>Orçamento</p>
              <span></span>
            </ContainerOrcamento>

            <FieldGroup>
              <InputGroup>
                <ContainerInput>
                  <label htmlFor="valorPassagem">Valor Passagem</label>
                  <input
                    id="valorPassagem"
                    type="text"
                    autoComplete="off"
                    required
                    value={valorPassagem}
                    onChange={(e) => handleFormatarMoeda(e, setValorPassagem)}
                  />
                </ContainerInput>
                <ContainerInput>
                  <label htmlFor="valorHospedagem">Valor Hospedagem</label>
                  <input
                    id="valorHospedagem"
                    type="text"
                    autoComplete="off"
                    required
                    value={valorHospedagem}
                    onChange={(e) => handleFormatarMoeda(e, setValorHospedagem)}
                  />
                </ContainerInput>
              </InputGroup>
              <InputGroup>
                <ContainerInput>
                  <label htmlFor="valorConsumo">Valor estipulado para consumo</label>
                  <input
                    id="valorConsumo"
                    type="text"
                    autoComplete="off"
                    required
                    value={valorConsumo}
                    onChange={(e) => handleFormatarMoeda(e, setValorConsumo)}
                  />
                </ContainerInput>
                <ContainerInput>
                  <label htmlFor="valorTotal">Total</label>
                  <input
                    id="valorTotal"
                    type="text"
                    autoComplete="off"
                    required
                    disabled
                    value={valorTotal}
                  />
                </ContainerInput>
              </InputGroup>
            </FieldGroup>

            <Divisor />
            <ContainerBtn>
              <span onClick={handleCancel}>Cancelar</span>
              <button type="submit">Salvar Alterações</button>
            </ContainerBtn>
          </Form>
        </Container>
      </ContainerMain>
    </>
  );
}

"use client";

import { ContainerDivisor, LoginBox, SectionLeft, SectionRight } from "./style";
import { TitleH1 } from "../../../components/titles";
import { InputText } from "../../../components/inputs";
import { LabelInput } from "../../../components/labels";
import { Divisor } from "../../../components/divisor";
import { ButtonForm } from "../../../components/buttons";
import { ErrorBox } from "../../../components/error";
import Image from "next/image";
import Link from "next/link";
import { useState } from "react";
import { login } from "@/api/login";

export default function SignIn() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [error, setError] = useState(""); // Estado para capturar erro

  const handleLogin = async () => {
    const response = await login(email, senha);

    // Verifique se o resultado é um LoginError
    if ("message" in response) {
      setError(response.message);
    } else {
      setError("");
    }
  };

  return (
    <>
      <ErrorBox visible={!!error}>
        <Image
          src="/assets/warning.png"
          alt="Imagem Erro"
          width={100}
          height={100}
        />
        
        {error && <p>{error}</p>}
      </ErrorBox>

      <div
        style={{
          display: "flex",
          alignItems: "center",
        }}
      >
        <SectionLeft>
          <ContainerDivisor>
            <Image
              src="/assets/imglogin.png"
              alt="Imagem Login"
              width={512}
              height={512}
            />
          </ContainerDivisor>
        </SectionLeft>

        <SectionRight>
          <ContainerDivisor>
            <LoginBox>
              <TitleH1>LOGIN</TitleH1>

              <Divisor />

              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  gap: "2.5em",
                  flexDirection: "column",
                }}
              >
                <div
                  style={{
                    display: "flex",
                    justifyContent: "center",
                    gap: "5px",
                    flexDirection: "column",
                  }}
                >
                  <LabelInput>E-mail</LabelInput>
                  <InputText
                    type="text"
                    placeholder="@mail.com"
                    autoComplete="off"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>

                <div
                  style={{
                    display: "flex",
                    justifyContent: "center",
                    gap: "5px",
                    flexDirection: "column",
                  }}
                >
                  <LabelInput>Senha</LabelInput>
                  <InputText
                    type="password"
                    autoComplete="off"
                    required
                    value={senha}
                    onChange={(e) => setSenha(e.target.value)}
                  />
                </div>

                <ButtonForm onClick={handleLogin}>Entrar</ButtonForm>
                <Link
                  href="/pages/auth/sign-up"
                  style={{
                    color: "#fff",
                  }}
                >
                  Não possui uma conta? Faça seu cadastro.
                </Link>
              </div>
            </LoginBox>
          </ContainerDivisor>
        </SectionRight>
      </div>
    </>
  );
}

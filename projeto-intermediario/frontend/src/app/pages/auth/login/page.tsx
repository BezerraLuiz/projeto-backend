"use client";

import { ContainerDivisor, LoginBox, SectionLeft, SectionRight } from "./style";
import { TitleH1 } from "../../../components/ui/titles";
import { InputText } from "../../../components/ui/inputs";
import { LabelInput } from "../../../components/ui/labels";
import { Divisor } from "../../../components/ui/divisor";
import { ButtonForm } from "../../../components/ui/buttons";
import { ErrorBox } from "../../../components/error/error";
import Image from "next/image";
import Link from "next/link";
import { login } from "@/api/login";
import { rememberAccount } from "@/api/rememberAccount";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [error, setError] = useState("");
  const router = useRouter();

  useEffect(() => {
    localStorage.removeItem("rememberAccount");
  }, []);

  // login user
  const handleLogin = async () => {
    const response = await login(email, senha);

    if (response.success == "false") {
      setError(response.message);

      setTimeout(() => {
        setError("");
      }, 3000);
    } else {
      setError("");
      router.push("/");
    }
  };

  // remeber password
  const handleRememberAccount = async () => {
    const checkbox = document.getElementById("check") as HTMLInputElement;

    if (!checkbox.checked) {
      return localStorage.removeItem("rememberAccount");
    }

    const response = await rememberAccount(email.toLowerCase()); // pegar id no backend

    if (response.success == "false") {
      setError(response.message);

      setTimeout(() => {
        setError("");
      }, 3000);
    } else {
      const userId = response.message;

      localStorage.setItem("rememberAccount", userId);
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
                    type="email"
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

                <div
                  style={{
                    display: "flex",
                    justifyContent: "space-between",
                    color: "#c9c9c9",
                    fontSize: "18px",
                    fontWeight: "bold",
                  }}
                >
                  <div
                    style={{
                      display: "flex",
                      gap: "10px",
                      color: "#c9c9c9",
                      fontSize: "18px",
                      fontWeight: "bold",
                    }}
                  >
                    <input
                      type="checkbox"
                      id="check"
                      onChange={handleRememberAccount}
                    />
                    <label htmlFor="check">Lembrar Usuário</label>
                  </div>

                  <Link
                    href="/pages/auth/login/rememberpass"
                    style={{
                      color: "#fff",
                    }}
                  >
                    Esqueceu a senha?
                  </Link>
                </div>

                <ButtonForm onClick={handleLogin}>Entrar</ButtonForm>
                <Link
                  href="/pages/auth/register"
                  style={{
                    color: "#fff",
                  }}
                >
                  Não possui uma conta? Faça seu cadastro.
                </Link>
              </div>
            </LoginBox>

            <p style={{
              position:"absolute",
              bottom: "0",
              margin: "0.5%",
              color: "#fff",
              fontSize: "12px",
            }}>Desenvolvido por Bytezest ©</p>
          </ContainerDivisor>
        </SectionRight>
      </div>
    </>
  );
}

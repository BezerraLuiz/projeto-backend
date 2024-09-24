'use client'

import { ContainerMain, RegisterBox } from "./style";
import { TitleH1 } from "../../../components/ui/titles";
import { ButtonForm } from "@/app/components/ui/buttons";
import { LabelInput } from "@/app/components/ui/labels";
import { InputText } from "@/app/components/ui/inputs";
import { useState } from "react";
import { Divisor } from "@/app/components/ui/divisor";
import { Footer } from "@/app/components/footer/footer";
import { register } from "@/api/user/register";
import { ErrorBox } from "@/app/components/error/error";
import { useRouter } from "next/navigation";
import Image from "next/image";
import Link from "next/link";

export default function Register() {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [senhaRepetida, setSenhaRepetida] = useState("");
  const [error, setError] = useState("");
  const router = useRouter(); 

  const handleRegister = async () => {
    if (senha != senhaRepetida) {
      setError("Senhas Diferentes!")
      return
    }

    const response = await register(nome, email, senha);

    if (response.success == "false") {
      setError(response.message);

      setTimeout(() => {
        setError("");
      }, 3000);
    } else {
      setError("");
      router.push("/pages/auth/login");
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

      <ContainerMain>
        <RegisterBox>
          <TitleH1>CADASTRO</TitleH1>

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
                  <LabelInput>Nome Completo</LabelInput>
                  <InputText
                    type="text"
                    autoComplete="off"
                    value={nome}
                    onChange={(e) => setNome(e.target.value)}
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
                    justifyContent: "center",
                    gap: "5px",
                    flexDirection: "column",
                  }}
                >
                  <LabelInput>Repetir Senha</LabelInput>
                  <InputText
                    type="password"
                    autoComplete="off"
                    required
                    value={senhaRepetida}
                    onChange={(e) => setSenhaRepetida(e.target.value)}
                  />
                </div>

                <div></div>

                <ButtonForm onClick={handleRegister}>Cadastrar</ButtonForm>
                <Link
                  href="/pages/auth/login"
                  style={{
                    color: "#fff",
                  }}
                >
                  Já possui uma conta? Faça seu login.
                </Link>
              </div>
        </RegisterBox>
      </ContainerMain>

      <Footer>Desenvolvido por Bytezest ©</Footer>
    </>
  )
}
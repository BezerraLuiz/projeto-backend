"use client";

import { ContainerDivisor, LoginBox, SectionLeft, SectionRight } from "./style";
import { TitleH1 } from "../../../components/titles";
import { InputText } from "../../../components/inputs";
import { LabelInput } from "../../../components/labels";
import { Divisor } from "../../../components/divisor";
import { ButtonForm } from "../../../components/buttons";
import Image from "next/image";
import Link from "next/link";

export default function SignIn() {
  return (
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
                  placeholder="@mail.com"
                  autoComplete="off"
                  required
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
                <InputText autoComplete="off" required />
              </div>

              <ButtonForm>Entrar</ButtonForm>
              <Link href="/pages/auth/sign-up" 
                style={{
                  color: "#fff"
                }}
              >Não possui uma conta? Faça seu cadastro.</Link>
            </div>
          </LoginBox>
        </ContainerDivisor>
      </SectionRight>
    </div>
  );
}

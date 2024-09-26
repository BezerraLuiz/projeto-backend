"use client";

import { InputText, InputFile } from "@/app/components/ui/inputs";
import {
  Background,
  ContainerMain,
  ContainerUser,
  DivInfosUser,
} from "./style";
import Image from "next/image";
import { Button, ButtonCancel } from "@/app/components/ui/buttons";
import { useEffect, useState } from "react";
import { viewuser } from "@/api/user/viewuser";
import { CiEdit } from "react-icons/ci";
import { useRouter } from "next/navigation";
import { updateuser } from "@/api/user/updateuser";

export default function User() {
  const [user, setUser] = useState({ id: "", nome: "", email: "", senha: "" });
  const [isDisabled, setIsDisabled] = useState({
    nome: true,
    email: true,
    senha: true,
  });
  const router = useRouter();

  useEffect(() => {
    const fetchUser = async () => {
      const account = sessionStorage.getItem("rememberAccount");

      if (account) {
        const response = await viewuser(account);

        const [id, nome, email, senha] = response.message.split(" | ");
        setUser({ id, nome, email, senha });
      } else {
        router.push("/pages/auth/login");
      }
    };

    fetchUser();
  }, []);

  const handleEdit = (field: string) => {
    setIsDisabled((prevState) => ({
      ...prevState,
      [field]: false,
    }));
  };

  const updateUser = async () => {
    const response = await updateuser(user.nome, user.email, user.senha);

    if (response.success) router.push("/");
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUser((prevUser) => ({ ...prevUser, [name]: value }));
  };

  const cancel = () => {
    router.push("/");
  };

  return (
    <>
      <Background>
        <ContainerMain>
          <ContainerUser>
            <Image
              src={"/assets/user.png"}
              alt="Image User"
              width={200}
              height={200}
              style={{ margin: "2.5%" }}
            />

            <DivInfosUser>
              <div style={{ display: "flex", alignItems: "center" }}>
                <div style={{ display: "flex", flexDirection: "column" }}>
                  Nome
                  <InputText
                    type="text"
                    name="nome"
                    value={user.nome}
                    disabled={isDisabled.nome}
                    onChange={handleChange}
                  />
                </div>

                <section
                  style={{ display: "flex", alignItems: "center" }}
                  onClick={() => handleEdit("nome")}
                >
                  <CiEdit
                    style={{
                      fontSize: "22.5px",
                      margin: "1%",
                      cursor: "pointer",
                    }}
                  />
                </section>
              </div>

              <div style={{ display: "flex", alignItems: "center" }}>
                <div style={{ display: "flex", flexDirection: "column" }}>
                  E-mail
                  <InputText
                    type="email"
                    name="email"
                    value={user.email}
                    disabled={isDisabled.email}
                    onChange={handleChange}
                  />
                </div>

                <section
                  style={{ display: "flex", alignItems: "center" }}
                  onClick={() => handleEdit("email")}
                >
                  <CiEdit style={{ fontSize: "22.5px", margin: "1%" }} />
                </section>
              </div>

              <div style={{ display: "flex", alignItems: "center" }}>
                <div style={{ display: "flex", flexDirection: "column" }}>
                  Senha
                  <InputText
                    type="password"
                    name="senha"
                    value={user.senha}
                    disabled={isDisabled.senha}
                    onChange={handleChange}
                  />
                </div>

                <section
                  style={{ display: "flex", alignItems: "center" }}
                  onClick={() => handleEdit("senha")}
                >
                  <CiEdit style={{ fontSize: "22.5px", margin: "1%" }} />
                </section>
              </div>

              <div style={{ display: "flex", flexDirection: "column" }}>
                Foto do Perfil
                <InputFile type="file" />
              </div>
            </DivInfosUser>

            <div
              style={{
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                gap: "10px",
                position: "fixed",
                bottom: "20%",
                right: "26%",
              }}
            >
              <ButtonCancel onClick={cancel}>Cancelar</ButtonCancel>
              <Button onClick={updateUser}>Salvar Alterações</Button>
            </div>
          </ContainerUser>
        </ContainerMain>
      </Background>
    </>
  );
}
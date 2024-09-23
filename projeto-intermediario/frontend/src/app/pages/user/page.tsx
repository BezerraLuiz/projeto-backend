"use client";

import { InputText, InputFile } from "@/app/components/ui/inputs";
import {
  Background,
  ContainerMain,
  ContainerUser,
  DivInfosUser,
} from "./style";
import Image from "next/image";

export default function User() {
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
              <div style={{ display: "flex", flexDirection: "column"}}>
                Nome
                <InputText type="text" />
              </div>

              <div style={{ display: "flex", flexDirection: "column"}}>
                E-mail
                <InputText type="email" />
              </div>

              <div style={{ display: "flex", flexDirection: "column"}}>
                Foto do Perfil
                <InputFile type="file" />
              </div>
            </DivInfosUser>


          </ContainerUser>
        </ContainerMain>
      </Background>
    </>
  );
}

// Para salvar a foto de perfil:

// Frontend: No formulário de perfil, crie um campo de upload de arquivo (input type="file").
// Ao enviar, utilize `FormData` para enviar a imagem para o backend.

// Backend:
//    - Crie um endpoint no Spring Boot para receber o arquivo (multipart/form-data).
//    - Utilize a classe `MultipartFile` para processar o upload da imagem.
//    - Armazene o arquivo em um diretório no servidor ou em um serviço de armazenamento externo (como Amazon S3).
//    - Salve o URL ou caminho da imagem no banco de dados (PostgreSQL).

// 3. Banco de Dados: No PostgreSQL, crie uma coluna na tabela de usuários para armazenar o URL da imagem.

// Com isso, o React envia a imagem para o Spring, que armazena e salva o caminho da foto no banco.

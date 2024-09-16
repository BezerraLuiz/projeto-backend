"use client";

import { ContainerMain, LoginBox } from "./style";
import { Title } from "../../../components/title/title";
import Image from "next/image";

export default function SignIn() {
	return (
		<div
			style={{
				display: "flex",
				alignItems: "center",
				justifyContent: "center",
			}}
		>
      <section style={{
        width: "50%"
      }}>
			<ContainerMain>
				<Image
					src="/assets/imglogin.jpeg"
					alt="Imagem Login"
					layout="fill" // Usa a largura e altura do contêiner pai
          objectFit="cover" // Cobre o contêiner sem distorcer a imagem
				/>
			</ContainerMain>
      </section>

			<ContainerMain>
				<LoginBox>
					<Title>Login</Title>
				</LoginBox>
			</ContainerMain>
		</div>
	);
}

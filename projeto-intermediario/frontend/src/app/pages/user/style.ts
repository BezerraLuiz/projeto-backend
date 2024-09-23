import { colors } from "@/app/styles/colors";
import styled from "styled-components";

export const Background = styled.body`
	width: 100%;
	height: 100%;
	background-color: ${colors.primary};
`;

export const ContainerMain = styled.div`
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
`;

export const ContainerUser = styled.section`
  display: flex;
	
	width: 60rem;
  height: 40rem;
	
  border: 1px solid #fff;
	border-radius: 20px;
`;

export const DivInfosUser = styled.div`
	display: flex;
	flex-direction: column;
	gap: 5%;
	
	margin: 5%;

	color: ${colors.text};
	font-size: 1.2em;
`;
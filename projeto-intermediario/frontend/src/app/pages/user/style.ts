import { colors } from "@/app/styles/colors/colors";
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
  width: 2rem;
  height: 2rem;
  border: 1px solid #fff;
`;

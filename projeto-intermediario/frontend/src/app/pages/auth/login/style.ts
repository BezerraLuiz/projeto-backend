import styled from "styled-components";
import { colors } from "@/app/styles/colors";

export const ContainerDivisor = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  min-height: 100vh;
`;

export const LoginBox = styled.section`
  display: flex;
  align-items: center;
  flex-direction: column;

  width: 40em;
  height: 45em;
  border: 3px solid ${colors.primary};
  border-radius: 20px;

  box-shadow: 5px 10px 15px 5px rgba(0, 0, 0, 0.25);
`;

export const SectionRight = styled.section`
  width: 100vw;
  height: 100vh;
  background-color: ${colors.primary};
`;

export const SectionLeft = styled.section`
  position: relative;
  width: 60vw;
  height: 100vh;
  border-right: 5px solid #fff;
`;

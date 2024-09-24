import styled from "styled-components";
import { colors } from "@/app/styles/colors";

export const ContainerMain = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 95vh;
`

export const RegisterBox = styled.section`
  display: flex;
  align-items: center;
  flex-direction: column;
  
  width: 40em;
  height: 52.5em;
  border: 3px solid #fff;
  border-radius: 20px;
  background-color: ${colors.primary};

  box-shadow: 5px 10px 15px 5px rgba(0, 0, 0, 0.45);
`;
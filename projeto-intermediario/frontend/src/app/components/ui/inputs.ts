import { colors } from "@/app/styles/colors";
import styled from "styled-components";

export const InputText = styled.input`
  width: 30em;
  height: 40px;
  padding: 10px;

  border: none;
  border-radius: 10px;
`;

export const InputFile = styled.input`
  width: 30em;
  height: 40px;
  padding: 10px;

  background-color: ${colors.text};
  color: ${colors.primary};
  font-weight: bold;
  border-radius: 10px;
`;
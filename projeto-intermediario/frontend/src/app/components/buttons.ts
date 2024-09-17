import styled from "styled-components";
import { colors } from "../styles/colors/colors";

export const ButtonForm = styled.button`
  width: 25em;
  height: 50px;

  border: 2.5px solid #fff;
  border-radius: 10px;
  background-color: ${colors.primary};
  
  font-size: 1em;
  font-weight: bold;
  color: #fff;

  transition: 0.5s ease-in-out;
  cursor: pointer;

  &:hover {
    background-color: #fff;
    color: ${colors.primary};
    border: 0.5 px solid #fff;
  }
`
import { colors } from "@/app/styles/colors/colors";
import styled from "styled-components";

export const Footer = styled.footer`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0.4%;
  font-size: 14px;
  position: absolute;
  bottom: 0;
  width: 100%;
  color: #fff;
  background-color: ${colors.primary};
`
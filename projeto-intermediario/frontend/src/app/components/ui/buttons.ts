import styled from "styled-components";
import { colors } from "../../styles/colors";

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

export const Button = styled.button`
  width: 12.5em;
  height: 50px;

  border: 2.5px solid #fff;
  border-radius: 10px;
  background-color: ${colors.text};
  
  font-size: 1em;
  font-weight: bold;
  color: ${colors.primary};

  transition: 0.5s ease-in-out;
  cursor: pointer;

  &:hover {
    background-color:  ${colors.primary};
    color: ${colors.text};
    border: 0.5 px solid #fff;
  }
`

export const ButtonCancel = styled.button`
  width: 12.5em;
  height: 50px;

  border: 2.5px solid #fff;
  border-radius: 10px;
  background-color: ${colors.error};
  
  font-size: 1em;
  font-weight: bold;
  color: ${colors.text};

  transition: 0.5s ease-in-out;
  cursor: pointer;

  &:hover {
    background-color:  ${colors.text};
    color: ${colors.error};
    border: 0.5 px solid #fff;
  }
`

export const ButtonCreateTravel = styled.section`
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
    border: 0.5px solid ${colors.primary};
  }
`;

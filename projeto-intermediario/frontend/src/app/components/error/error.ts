import styled from "styled-components";
import { colors } from "../../styles/colors";

interface ErrorBoxProps {
  visible: boolean;
}

export const ErrorBox = styled.section<ErrorBoxProps>`
  z-index: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  
  position: fixed;
  bottom: 0;
  margin: 1%;
  padding: 1em 2em;

  max-width: 90vw;
  background-color: ${colors.error};
  border-radius: 12px;
  
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
  transition: opacity 0.5s ease, transform 0.5s ease, visibility 0.5s ease;
  opacity: ${(props) => (props.visible ? 1 : 0)};
  visibility: ${(props) => (props.visible ? "visible" : "hidden")};
  transform: ${(props) => (props.visible ? "translateY(0)" : "translateY(20px)")};

  & p {
    color: #fff;
    font-size: 18px;
    margin: 0;
    text-align: center;
    line-height: 1.4;
  }
`

// <ErrorBox visible={!!error}>
//         <Image
//           src="/assets/warning.png"
//           alt="Imagem Erro"
//           width={100}
//           height={100}
//         />

//         {error && <p>{error}</p>}
//       </ErrorBox>
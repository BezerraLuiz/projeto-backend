import styled from 'styled-components'
import { colors } from '@/app/styles/colors/colors'

export const ContainerMain = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
`

export const LoginBox = styled.section`
  width: 30em;
  height: 35em;
  border: 3px solid ${colors.primary};
  border-radius: 20px;

  box-shadow: 5px 10px 15px 5px rgba(0, 0, 0, 0.5);
`
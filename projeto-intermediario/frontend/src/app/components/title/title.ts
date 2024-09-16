import { colors } from '@/app/styles/colors/colors'
import styled from 'styled-components'

export const Title = styled.h1`
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0.5em;
  
  font-size: 3em;
  color: #fff;
  -webkit-text-stroke-width: 2px; /* largura da borda */
  -webkit-text-stroke-color: ${colors.primary}; /* cor da borda */
`
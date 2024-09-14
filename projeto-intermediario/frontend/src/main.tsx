import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './style/index.ts'
import { RouterProvider } from 'react-router-dom'
import { router } from './routes'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={ router } />
  </StrictMode>,
)

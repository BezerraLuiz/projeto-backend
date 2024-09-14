import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import SignUp from "./pages/auth/sign-up/sign-up.tsx"

export const router = createBrowserRouter([
  {
    path: '/',
    element: <App />
  },
  {
    path: '/signup',
    element: <SignUp />,
  },
])
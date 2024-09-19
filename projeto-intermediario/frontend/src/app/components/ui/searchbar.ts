import styled from "styled-components";

export const SearchBar = styled.section`
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 0.5%;

  width: 15em;

  border-radius: 10px;
  background-color: #fff;
  font-size: 30px;

  & input {
    font-size: 16px;
  }
`

// <SearchBar>
//         <IoIosSearch />
//         <input type="text" placeholder="Buscar viagem..."
//           style={{
//             outline: "none",
//             border: "none",
//           }}
//           autoComplete="off"
//         />
//       </SearchBar>
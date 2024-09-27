import styled from "styled-components";

export const ContainerMain = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  padding: 20px;
  background-color: #f4f4f9;
`;

export const Container = styled.div`
  width: 100%;
  max-width: 900px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
  padding: 30px;
  box-sizing: border-box;
`;

export const Form = styled.form`
  display: flex;
  flex-direction: column;
`;

export const FieldGroup = styled.div`
  margin-bottom: 20px;
`;

export const InputGroup = styled.div`
  display: flex;
  gap: 20px;
  flex-wrap: wrap;
`;

export const ContainerInput = styled.div`
  flex: 1;
  margin-bottom: 20px;

  label {
    display: block;
    font-weight: bold;
    margin-bottom: 8px;
    color: #5350c1;
  }

  input {
    width: 100%;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 4px;
    background-color: #fafafa;
    color: #333;
    font-size: 16px;

    &:disabled {
      background-color: #e0e0e0;
      cursor: not-allowed;
    }
  }
`;

export const ContainerOrcamento = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;

  p {
    margin: 0 15px;
    font-weight: bold;
    font-size: 20px;
    color: #5350c1;
  }
`;

export const Divisor = styled.hr`
  border: 0;
  height: 1px;
  background-color: #e5e5e5;
  margin: 20px 0;
`;

export const ContainerBtn = styled.div`
  display: flex;
  justify-content: space-between;

  span {
    cursor: pointer;
    color: #f00;
    font-weight: bold;

    &:hover {
      text-decoration: underline;
    }
  }

  button {
    background-color: #5350c1;
    color: white;
    font-weight: bold;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;

    &:hover {
      background-color: #6a64d4;
    }
  }
`;

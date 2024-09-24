"use client";

import Image from "next/image";
import { Header } from "./components/header/header";
import { SearchBar } from "./components/ui/searchbar";
import { IoIosSearch } from "react-icons/io";
import Link from "next/link";
import { useEffect } from "react";

export default function Home() {

  useEffect(() => {
    if (localStorage.length == 2) {
      const account = localStorage.getItem("rememberAccount")
      
      if (account) sessionStorage.setItem("rememberAccount", account);
    } 
  }, [])

  return (
    <Header>
      <Image
        src="/assets/icon.png"
        alt="Icon"
        width={60}
        height={60}
      />

      <SearchBar>
        <IoIosSearch />
        <input type="text" placeholder="Buscar viagem..."
          style={{
            outline: "none",
            border: "none",
          }}
          autoComplete="off"
        />
      </SearchBar>

      <Link href="/pages/user"
                    ><Image
        src="/assets/user.png"
        alt="Icon"
        width={60}
        height={60}

        style={{
          cursor: "pointer"
        }}
      /></Link>
    </Header>
  );
}

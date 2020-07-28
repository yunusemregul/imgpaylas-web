import React, { useEffect } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import axios from "axios";

export default function Home() {
  useEffect(() => {
    axios.get("/api/v1/image/all").then((res) => {
      console.log(res);
    });
    return () => {};
  }, []);

  return (
    <div className="box">
      <Header />
      <DivBackground color="#F3F4F5">Hello!</DivBackground>
    </div>
  );
}

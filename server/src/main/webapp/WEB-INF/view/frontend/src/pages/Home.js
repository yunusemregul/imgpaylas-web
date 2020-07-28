import React from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";

export default function Home() {
  return (
    <div className="box">
      <Header />
      <DivBackground>Hello!</DivBackground>
    </div>
  );
}

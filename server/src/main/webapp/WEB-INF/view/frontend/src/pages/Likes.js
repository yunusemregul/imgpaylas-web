import axios from "axios";
import React, { useEffect, useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import ImageBox from "../components/ImageBox";
import ResponsiveMasonry from "../components/ResponsiveMasonry";

export default function Likes() {
  const [likes, setLikes] = useState([]);

  useEffect(() => {
    axios.get("/api/v1/image/my_likes").then((res) => {
      if (res.status === 200) {
        setLikes(res.data);
      }
    });
    return () => {};
  }, []);

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Beğendiklerin" />
      <DivBackground backgroundColor="#444444">
        <ResponsiveMasonry>
          {likes.map((image) => {
            return <ImageBox key={image.id} data={image} userLiked={true} />;
          })}
        </ResponsiveMasonry>
      </DivBackground>
    </div>
  );
}

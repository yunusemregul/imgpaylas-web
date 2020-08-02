import React, { useEffect, useState } from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";
import Masonry from "react-masonry-css";
import axios from "axios";
import ImageBox from "../components/ImageBox";

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
        <Masonry
          breakpointCols={3}
          className="my-masonry-grid"
          columnClassName="my-masonry-grid_column"
        >
          {likes.map((image) => {
            return <ImageBox key={image.id} data={image} userLiked={true} />;
          })}
        </Masonry>
      </DivBackground>
    </div>
  );
}

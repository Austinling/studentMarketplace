import { MainSearch } from "../components/MainSearch";
import { TopNavBar } from "../components/TopNavBar";

export default function HomePage() {
  return (
    <main className="flex flex-col h-full">
      <TopNavBar />
      <MainSearch />
    </main>
  );
}

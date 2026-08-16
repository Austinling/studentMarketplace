import { MainSearch } from "../ui/components/MainSearch";
import { MainSection } from "../ui/components/MainSection";
import { TopNavBar } from "../ui/components/TopNavBar";

export default function HomePage() {
  return (
    <main className="flex flex-col h-full">
      <TopNavBar />
      <MainSection />
    </main>
  );
}
